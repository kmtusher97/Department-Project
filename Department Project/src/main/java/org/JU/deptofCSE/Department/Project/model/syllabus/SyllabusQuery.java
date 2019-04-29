package org.JU.deptofCSE.Department.Project.model.syllabus;

public class SyllabusQuery {

    private String category;

    private Integer from;

    private Integer to;

    private String session;

    public SyllabusQuery() {
        this.category = "";
        this.from = 0;
        this.to = 0;
        this.session = "";
    }

    public SyllabusQuery(String category,
                         Integer from,
                         Integer to,
                         String session) {
        this.category = category;
        this.from = from;
        this.to = to;
        this.session = session;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    /**
     * Generate an object of Syllabus class with the xml file name
     * @param fileName
     */
    public SyllabusQuery(String fileName) {
        this.from = 0;
        this.to = 0;
        this.category = "";

        int index = 0;
        for(; index < fileName.length(); index++) {
            if(Character.isLetter(fileName.charAt(index))) {
                this.category += fileName.charAt(index);
            }
            else {
                break;
            }
        }
        String yearFrom = "";
        String yearTo = "";
        for(index = index + 1; index < fileName.length(); index++) {
            if(Character.isDigit(fileName.charAt(index))) {
                yearFrom += fileName.charAt(index);
            }
            else {
                break;
            }
        }
        for(; index < fileName.length(); index++) {
            if(Character.isDigit(fileName.charAt(index))) {
                yearTo += fileName.charAt(index);
            }
            else {
                continue;
            }
        }
        this.from = Integer.parseInt(yearFrom);
        this.to = Integer.parseInt(yearTo);
    }

    /**
     * parse form and to from session
     */
    public void parseSession(String session) {
        int year = 0, powerOf10 = 1;
        for(int i = 3; i >= 0; i--) {
            year += ((session.charAt(i) - '0') * powerOf10);
            powerOf10 *= 10;
        }
        this.from = year;
        this.to = year + 1;
    }

    @Override
    public String toString() {
        return "SyllabusQuery{" +
                "category='" + category + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", session='" + session + '\'' +
                '}';
    }
}
