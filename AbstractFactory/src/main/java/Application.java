import factory.Factory;
import factory.Link;
import factory.Page;
import factory.Tray;

public class Application {

    public static void main(String[] args) {

        makeHtml("listFactory", "listFactory.ListFactory");
        makeHtml("divFactory", "divFactory.DivFactory");

        Factory factory = Factory.getFactory("divFactory.DivFactory");
        Page page = factory.createNaverPage();
        page.output("naver.html");
    }

    private static void makeHtml(String fileName, String className) {

        Factory factory = Factory.getFactory(className);

        //Blog
        Link blog1 = factory.createLink("Blog 1", "https://example.com/blog1");
        Link blog2 = factory.createLink("Blog 2", "https://example.com/blog2");
        Link blog3 = factory.createLink("Blog 3", "https://example.com/blog3");

        Tray blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        //News
        Link news1 = factory.createLink("News 1", "https://example.com/new1");
        Link news2 = factory.createLink("News 2", "https://example.com/new2");
        Tray news3 = factory.createTray("News 3");
        news3.add(factory.createLink("News 3 (US)", "https://example.com/new3us"));
        news3.add(factory.createLink("News 3 (KOREA)", "https://example.com/new3kr"));

        Tray newsTray = factory.createTray("News Site");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        //Page
        Page page = factory.createPage("Blog And News", "JSH.com");
        page.add(blogTray);
        page.add(newsTray);

        page.output(fileName + ".html");

    }

}
