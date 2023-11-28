package factory;

public abstract class Factory {

    public static Factory getFactory(String className) {
        Factory factory = null;

        try {
            factory = (Factory) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println(className + " 클래스를 찾지 못했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);

    public Page createNaverPage() {
        Link link = createLink("Naver", "https://naver.com");
        Page page = createPage("Naver", "Naver");
        page.add(link);
        return page;
    }
}
