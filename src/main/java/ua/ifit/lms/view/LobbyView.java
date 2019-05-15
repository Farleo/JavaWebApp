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

        String allRooms = rooms.stream().map(r -> {
            String text = "";
            if (r.getName() != null) {
                text = r.getName().length() > 20 ? r.getName().substring(0, 19) : r.getName();
            }
            return "<a class=\"room-short-view\" href=\"/lobby/edit?id=" + r.getId() + "\">" +
                    "<div class=\"col-6 col-sm-4 col-md-3\" style=\"background-color:  #fff;\">\n" +
                    "<h3 style=\"color: #fff ;\">" + text + "</h3>\n" +
                    "<p style=\"color: #fff;\">" + r.getDescription() +
                    "</p>\n" +
                    "</div>\n" +
                    "</a>";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-room-###-->", allRooms);
    }

    public String getExistingRoom(User user, Room room) {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        return indexSingleton.getIndexHtml()
                .replace("<!--###header###-->", MenuHelper.GetMenu(user))
                .replace("<!--###content###-->", indexSingleton.getLobbyForm())
                .replace("></textarea>", ">" +
                        room.getName() +
                        "</textarea>")
                .replace("<!--###existing-room-id###-->", "<input name=\"roomid\" type=\"hidden\" value=\"" + room.getId() + "\">");
    }
}
