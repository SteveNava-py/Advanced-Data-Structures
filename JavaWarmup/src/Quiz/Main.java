package Quiz;

public class Main {
    String height;
    String weight;

    public static void main(String[] args) {

        Main bio = new Main();
        bio.height = "5'7";
        bio.weight = "125";
        System.out.println(bio.getHeight() + " " + bio.getWeight());

    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

}
