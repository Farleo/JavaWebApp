package ua.ifit.lms.view;

import ua.ifit.lms.dao.entity.User;

public class LoginView {

    public String getloginPage(boolean isSuccessfullLogin) {
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String loginForm = indexSingletonView.getLoginForm();
        String loginFormFail = indexSingletonView.getLoginFormFail();
        String menu = indexSingletonView.getMenu();
        return indBase
                .replace("<!--###header###-->", menu)
                .replace("<!--###content###-->", isSuccessfullLogin ? loginForm : loginFormFail);
    }

    public String welcomUserPage(User user) {
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String menu = indexSingletonView.getMenu();
        return indBase
                .replace("<!--###header###-->", menu)
                .replace("<!--###content###-->", "Hello " + user.getName());
    }

    public String getRegisterPage() {
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String registerForm = indexSingletonView.getRegister();
        String menu = indexSingletonView.getMenu();
        return indBase
                .replace("<!--###header###-->", menu)
                .replace("<!--###content###-->", registerForm);
    }
}
