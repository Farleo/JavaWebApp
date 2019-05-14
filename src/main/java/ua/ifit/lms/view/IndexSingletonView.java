package ua.ifit.lms.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexSingletonView {

    private String path;
    private String header;
    private String indexHtml;
    private String loginForm;
    private String loginFormFail;
    private String lobbyForm;
    private String lobbyIndex;
    private String menu;
    private String register;

    private static IndexSingletonView ourInstance = new IndexSingletonView();

    public static IndexSingletonView getInstance() {
        return ourInstance;
    }

    private IndexSingletonView() {
    }

    public void setPath(String path) {
        this.path = path;
        this.indexHtml = getPartialHtml("index");
        this.header = getPartialHtml("header");
        this.loginForm = getPartialHtml("login-form");
        this.loginFormFail = getPartialHtml("login-form-fail");
        this.lobbyForm = getPartialHtml("lobby-form");
        this.lobbyIndex = getPartialHtml("lobby-index");
        this.menu = getPartialHtml("menu");
        this.register = getPartialHtml("register");
    }

    public String getIndexHtml() {
        return indexHtml;
    }

    public String getHeader() { return header; }

    public String getLoginForm() {
        return loginForm;
    }

    public String  getLobbyForm() {
        return lobbyForm;
    }

    public String  getLobbyIndex() {
        return lobbyIndex;
    }

    public String getMenu() {
        return menu;
    }

    public String getLoginFormFail() {
        return loginFormFail;
    }

    public String getRegister() {
        return register;
    }

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
