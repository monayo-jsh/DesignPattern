public class Application {

    public static void main(String[] args) {

        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        binDir.add(new File("vi", 100));
        binDir.add(new File("latex", 1000));

        rootDir.printList();
        System.out.println();

        Directory youngjoin = new Directory("youngjin");
        Directory gildong = new Directory("gildong");
        Directory dojun = new Directory("dojun");

        usrDir.add(youngjoin);
        usrDir.add(gildong);
        usrDir.add(dojun);

        youngjoin.add(new File("diary.html", 100));
        File compositeJavaFile = new File("Composite.java", 200);
        youngjoin.add(compositeJavaFile);

        gildong.add(new File("memo.tex", 300));

        dojun.add(new File("game.doc", 400));
        dojun.add(new File("junk.mail", 500));

        rootDir.printList();

        System.out.println();

        System.out.println("compositeJavaFile path = " + compositeJavaFile.getFullPath());
        System.out.println("youngjoin path = " + youngjoin.getFullPath());
    }

}
