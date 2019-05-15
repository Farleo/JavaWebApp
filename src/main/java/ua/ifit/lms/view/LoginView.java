package ua.ifit.lms.view;

import ua.ifit.lms.dao.entity.User;

public class LoginView {

    public String getLoginPage(User user) {
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String loginForm = indexSingletonView.getLoginForm();
        String loginFormFail = indexSingletonView.getLoginFormFail();
        String menu = MenuHelper.GetMenu(user);
        return indBase
                .replace("<!--###header###-->", menu)
                .replace("<!--###content###-->", user != null ? loginForm : loginFormFail);
    }

    public String getWelcomePage(User user) {
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String menu = MenuHelper.GetMenu(user);
        return indBase
                .replace("<!--###header###-->", menu)
                .replace("<!--###content###-->", "Hello " + user.getName());
    }

    public String getRegisterPage(User user) {
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        String indBase = indexSingletonView.getIndexHtml();
        String registerForm = indexSingletonView.getRegister();
        String menu = MenuHelper.GetMenu(user);
        return indBase
                .replace("<!--###header###-->", menu)
                .replace("<!--###content###-->", registerForm);
    }
}
