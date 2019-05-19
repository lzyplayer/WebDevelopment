package hello;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoTask {
    private long id;
    private String content;
    private String createdTime;

    public TodoTask(long id, String content) {
        this.id = id;
        this.content = content;
        Date date =new Date();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.createdTime = simpleDateFormat.format(date);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedTime() {
        return createdTime;
    }
}
