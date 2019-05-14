package ua.ifit.lms.view;

import ua.ifit.lms.dao.entity.Room;

import java.util.List;
import java.util.stream.Collectors;

public class LobbyView {

    public String getHtml() {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        return indexSingleton.getIndexHtml()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getLobbyForm());
    }

    public String getIndex(List<Room> rooms) {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        String page = indexSingleton.getIndexHtml()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getLobbyIndex());

        String allNotes = rooms.stream().map(r -> {
            String text = "";
            if (r.getName() != null) {
                text = r.getName().length() > 20 ? r.getName().substring(0, 19) : r.getName();
            }
            return "<a class=\"note-short-view\" href=\"/note/edit?id=" + r.getId() + "\">" +
                    "<div class=\"col-6 col-sm-4 col-md-3\" style=\"background-color:  #fff;\">\n" +
                    "<h3 style=\"color: #fff ;\">" + text + "</h3>\n" +
                    "<p style=\"color: #fff;\">" + r.getDescription() +
                    "</p>\n" +
                    "</div>\n" +
                    "</a>";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-note-###-->", allNotes);
    }

    public String getExistingRoom(Room room) {
        IndexSingletonView indexSingleton = IndexSingletonView.getInstance();
        return indexSingleton.getIndexHtml()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getLobbyForm())
                .replace("></textarea>", ">" +
                        room.getName() +
                        "</textarea>")
                .replace("<!--###existing-note-id###-->", "<input name=\"noteid\" type=\"hidden\" value=\"" + room.getId() + "\">");
    }
}
