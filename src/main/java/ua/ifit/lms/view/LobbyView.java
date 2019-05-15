package ua.ifit.lms.view;

import ua.ifit.lms.dao.entity.Room;
import ua.ifit.lms.dao.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class LobbyView {

    public String getHtml(User user) {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        return indexSingleton.getIndexHtml()
                .replace("<!--###header###-->", MenuHelper.GetMenu(user))
                .replace("<!--###content###-->", indexSingleton.getLobbyForm());
    }

    public String getIndex(User user, List<Room> rooms) {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        String page = indexSingleton.getIndexHtml()
                .replace("<!--###header###-->", MenuHelper.GetMenu(user))
                .replace("<!--###content###-->", indexSingleton.getLobbyIndex());

        String allRooms = rooms.stream().map(r -> indexSingleton.getLobbyItem()
                    .replace("<!--###name###-->", r.getName())
                    .replace("<!--###description###-->", r.getDescription()))
                .collect(Collectors.joining(" "));
        return page.replace("<!--###-add-rooms-###-->", allRooms);
    }
}
