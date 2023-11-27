public enum Triple {
    ALPHA, BETA, GAMMA;

    public static Triple getInstance(String name) {
        return valueOf(name);
    }
}
