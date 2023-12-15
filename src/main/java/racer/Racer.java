package racer;

public class Racer {

    String name;
    int advance;
    
    public Racer(String nameText) {
        validateNameString(nameText);
        this.name = nameText;
        this.advance = 0;
    }
    
    private void validateNameString(String nameText) throws IllegalArgumentException {
        if (nameText.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 이름은 0자일 수 없습니다.");
        }
        if (nameText.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자를 넘을 수 없습니다.");
        }
        if (nameText.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 이름에 공백은 포함될 수 없습니다.");            
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAdvance() {
        return this.advance;
    }
    
    public void increaseAdvance() {
        this.advance++;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
