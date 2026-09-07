package Structural.Composite.JetpackCompose;

import Structural.Bridge.MultiPlatform.ICommonUI;

import java.util.List;

public class Program {
    static void main(String[] args) {
        IComponent tv1 = new TextView("Name Text View");
        IComponent tv2 = new TextView("Age Text View");
        IComponent profileImg = new ImageView("Profile Picture");
        IComponent webView = new WebView("Web View");

        IComponent container = new Container("children", List.of(
                tv1,tv2,profileImg,webView
        ));
    }
}
