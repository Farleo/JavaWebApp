package ua.ifit.lms.view;

import ua.ifit.lms.dao.entity.User;

public class MainView {
    public String getHtml(User user) {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        String html = indexSingleton.getIndexHtml()
        .replace("<!--###header###-->", MenuHelper.GetMenu(user))
        .replace("<!--###content###-->", indexSingleton.getLoginForm());
        return html;
    }
}
