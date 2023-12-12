import pagemaker.PageMaker;

public class Application {

    public static void main(String[] args) {

        PageMaker.makeWelcomePage("monayo.jsh@gmail.com", "welcome.html");
        PageMaker.makeLinkPage("linkpage.html");

        //Java 15 정식 출시된 기능 텍스트블록
        String html = """
        <!DOCTYPE html>
            <head>
                <title>Welcome!</title>
            </head>
            <body>
                <h1 style="text-align: center;">Hello, world!</h1>
            </body>
        </html>
        """;
        System.out.println(html);
    }

}
