package io.github.dadpea.texal.style;

public enum GlobalColors {
    RED("#FF3838"), DARK_RED("#CC2C2C"),
    YELLOW("#FFDD61"), DARK_YELLOW("#CCB14F"),
    GREEN("#7CFF68"), DARK_GREEN("#63CC53"),
    TEAL("#14FFE1"), DARK_TEAL("#10CCB2"),
    BLUE("#3D50FF"), DARK_BLUE("#3040CC"),
    PURPLE("#C044FF"), DARK_PURPLE("#9A37CC"),
    WHITE("#FFFFFF"), LIGHT_GRAY("#CCCCCC"),
    GRAY("#999999"), DARK_GRAY("#666666");

    String textRepresentation;
    private GlobalColors(String hex) {
        this.textRepresentation = ColorConvert.fromHex(hex);
    }

    @Override
    public String toString() {
        return this.textRepresentation;
    }
}
