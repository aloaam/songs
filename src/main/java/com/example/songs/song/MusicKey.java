package com.example.songs.song;

public enum MusicKey {

    A("a_major"),
    B("b_major"),
    C("c_major"),
    D("d_major"),
    E("e_major"),
    F("f_major"),
    G("g_major"),
    AM("a_minor"),
    BM("b_minor"),
    CM("c_minor"),
    DM("d_minor"),
    EM("e_minor"),
    FM("f_minor"),
    GM("g_minor");

    private final String key;

    MusicKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
