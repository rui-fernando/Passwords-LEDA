import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dados_password {
    private String password;
    private int length;
    private String date; 
    private String classification;
    private int index;

    public Dados_password(int index, String password, int length, String date, String classification) {
        this.index = index;
        this.password = password;
        this.length = length;
        this.date = date;
        this.classification = classification;
    }

    public int getIndex() {
        return index;
    }

    public String getPassword() {
        return password;
    }

    public int getLength() {
        return length;
    }

    public LocalDate getDate() {
        DateTimeFormatter foramtada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, foramtada);
    }

    public String getFormattedDate() {
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getDate().format(formatada);
    }

    public int getMonth() {
        return getDate().getMonthValue();
    }

    public String getClassification() {
        return classification;
    }
}