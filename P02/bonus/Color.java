public class Color {
    Black(0x000000),White(0xFFFFFF),Pink(0xFFC0CB),Silver(0x808080);

    private int rgb;

    private Color(int rgb){
        this.rgb=rgb;
    }

    public String toString(){
        return this.name() + " (0x" + String.format("%06X", rgb) + ")";
    }
}
