package ua.ifit.lms.view;

import ua.ifit.lms.dao.entity.User;

public class MenuHelper {
    static String GetMenu(User user)
    {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        String menu =
                user == null
                        ? indexSingleton.getMenu()
                        : indexSingleton.getMenuWithUser().replace("<!--###user###-->", user.getName());
        return menu;
    }
}
