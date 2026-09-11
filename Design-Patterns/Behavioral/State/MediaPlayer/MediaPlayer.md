# State Pattern — Media Player Example

## Overview

This example demonstrates the **State Design Pattern** using a Media Player.

The media player changes its behavior depending on its current state:

- Stopped
- Playing
- Paused

Instead of putting state-specific logic inside `MediaPlayer` with `if/else` or `switch`, each state implements its own behavior.

## Problem

A media player can behave differently when the same operation is requested.

For example:

- `play()` while stopped should start the media.
- `play()` while already playing should report that it is already playing.
- `play()` while paused should resume the media.
- `pause()` while stopped is invalid.
- `pause()` while playing should pause the media.
- `stop()` should behave differently depending on the current state.

A large collection of `if/else` statements inside `MediaPlayer` would make the class harder to maintain.

## Solution

The **State Pattern** moves state-specific behavior into separate classes.

`MediaPlayer` acts as the **Context** and delegates operations to its current `MediaPlayerState`.

### Pattern Structure

```text
                    MediaPlayer
                     (Context)
                         |
                         v
                MediaPlayerState
                    (State)
                  /     |      \
                 /      |       \
                v       v        v
        StoppedState PlayingState PausedState
        (Concrete)    (Concrete)   (Concrete)
```

## Pattern Roles

| Role | Class | Responsibility |
|---|---|---|
| Context | `MediaPlayer` | Stores the current state and delegates operations |
| State | `MediaPlayerState` | Defines the operations supported by all states |
| Concrete State | `StoppedState` | Defines behavior while stopped |
| Concrete State | `PlayingState` | Defines behavior while playing |
| Concrete State | `PausedState` | Defines behavior while paused |
| Client | `Program` | Uses the media player |

## User's Solution

### MediaPlayerState

```java
public interface MediaPlayerState {
    void play(MediaPlayer player);
    void pause(MediaPlayer player);
    void stop(MediaPlayer player);
}
```

The interface defines the operations that every state must implement.

### MediaPlayer

```java
public class MediaPlayer {
    private MediaPlayerState playerState;

    public MediaPlayer(){
        playerState = new StoppedState();
    }

    public void play(){
        this.playerState.play(this);
    }

    public void pause(){
        this.playerState.pause(this);
    }

    public void stop(){
        this.playerState.stop(this);
    }

    public void setState(MediaPlayerState state){
        this.playerState = state;
    }
}
```

`MediaPlayer` is the **Context**.

It does not contain the state-specific rules. Instead, it delegates `play()`, `pause()`, and `stop()` to the current state.

## Concrete States

### StoppedState

```java
public class StoppedState implements MediaPlayerState {
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Starting media");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Cannot pause. Media is stopped.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Media is already stopped.");
    }
}
```

When stopped:

- `play()` starts the media and changes the state to `PlayingState`.
- `pause()` is rejected.
- `stop()` reports that the media is already stopped.

### PlayingState

```java
public class PlayingState implements MediaPlayerState {
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Media is already playing.");
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Media Paused!");
        player.setState(new PausedState());
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Media stopped.");
        player.setState(new StoppedState());
    }
}
```

When playing:

- `play()` reports that the media is already playing.
- `pause()` changes the state to `PausedState`.
- `stop()` changes the state to `StoppedState`.

### PausedState

```java
public class PausedState implements MediaPlayerState {
    @Override
    public void play(MediaPlayer player) {
        System.out.println("Resuming media..");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MediaPlayer player) {
        System.out.println("Media is already paused.");
    }

    @Override
    public void stop(MediaPlayer player) {
        System.out.println("Media stopped.");
        player.setState(new StoppedState());
    }
}
```

When paused:

- `play()` resumes the media and changes to `PlayingState`.
- `pause()` reports that it is already paused.
- `stop()` changes to `StoppedState`.

## Execution Flow

The client executes:

```java
MediaPlayer player = new MediaPlayer();

player.pause();
player.play();
player.play();
player.pause();
player.pause();
player.play();
player.stop();
player.stop();
```

The state transitions are:

```text
Initial
  |
  v
Stopped
  |
 play()
  v
Playing
  |
 pause()
  v
Paused
  |
 play()
  v
Playing
  |
 stop()
  v
Stopped
```

Some operations do not cause a transition because they are invalid or redundant for the current state.

## Expected Behavior

```text
Cannot pause. Media is stopped.
Starting media
Media is already playing.
Media Paused!
Media is already paused.
Resuming media..
Media stopped.
Media is already stopped.
```

## Why This Is the State Pattern

This implementation is a State Pattern because the behavior of the same object changes according to its current state.

For example:

```java
player.play();
```

can mean different things:

```text
Stopped  → Start media
Playing  → Already playing
Paused   → Resume media
```

The client still calls the same method, but the current state determines the behavior.

## Important Design Point

The main purpose of the State Pattern is **not simply removing `if/else`**.

The deeper purpose is:

> Encapsulate state-specific behavior so an object's behavior changes when its internal state changes.

## Key Takeaways

- `MediaPlayer` is the Context.
- `MediaPlayerState` is the State interface.
- Each concrete state owns its own behavior.
- States can transition the Context to another state.
- `MediaPlayer` does not need `if/else`, `switch`, or `instanceof`.
- The pattern makes state-dependent behavior easier to extend and maintain.

### Memory Trick

**State Pattern = BEHAVIOR CHANGES WITH STATE**
