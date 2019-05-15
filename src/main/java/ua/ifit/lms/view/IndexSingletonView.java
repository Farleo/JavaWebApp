package ua.ifit.lms.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexSingletonView {

    private String path;

    private String indexHtml;
    private String menu;
    private String menuWithUser;

    private String registerForm;
    private String loginForm;
    private String loginFormFail;

    private String lobbyIndex;
    private String lobbyForm;
    private String lobbyItem;



    private static IndexSingletonView ourInstance = new IndexSingletonView();

    public static IndexSingletonView getInstance() {
        return ourInstance;
    }

    private IndexSingletonView() {
    }

    public void setPath(String path) {
        this.path = path;
        this.indexHtml = getPartialHtml("index");
        this.menu = getPartialHtml("menu");
        this.menuWithUser = getPartialHtml("menu-logged-in");

        this.registerForm = getPartialHtml("register");
        this.loginForm = getPartialHtml("login-form");
        this.loginFormFail = getPartialHtml("login-form-fail");

        this.lobbyForm = getPartialHtml("lobby-form");
        this.lobbyItem = getPartialHtml("lobby-item");
        this.lobbyIndex = getPartialHtml("lobby-index");
    }

    /* Main */
    public String getIndexHtml() { return indexHtml; }

    public String getMenu() { return menu; }

    public String getMenuWithUser() { return menuWithUser; }

    /* Login */
    public String getRegister() { return registerForm; }

    public String getLoginForm() { return loginForm; }

    public String getLoginFormFail() { return loginFormFail; }

    /* Lobby */
    public String  getLobbyForm() { return lobbyForm; }

    public String  getLobbyItem() { return lobbyItem; }

    public String  getLobbyIndex() { return lobbyIndex; }

    private String getPartialHtml(String filename){
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.path + filename + ".html");
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return strb.toString();
    }


}
