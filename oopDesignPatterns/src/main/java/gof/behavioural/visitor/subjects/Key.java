package gof.behavioural.visitor.subjects;

public enum Key {
    A(true),
    B(true),
    C(true),
    D(true),
    E(true),
    F(true),
    G(true),
    H(true),
    I(true),
    J(true),
    K(true),
    L(true),
    M(true),
    N(true),
    O(true),
    P(true),
    Q(true),
    R(true),
    S(true),
    T(true),
    U(true),
    V(true),
    W(true),
    X(true),
    Y(true),
    Z(true),
    SPACE(true),
    SHIFT(false),
    CTRL(false),
    CAPSLOCK(false),
    TAB(false),
    DASH(true),
    EQUALS(true),
    ONE(true),
    TWO(true),
    THREE(true),
    FOUR(true),
    FIVE(true),
    SIX(true),
    SEVEN(true),
    EIGHT(true),
    NINE(true),
    ZERO(true),
    ESCAPE(true),
    BACKSPACE(true);

    private boolean isInput;
    public boolean isInput() {
        return this.isInput;
    }
    Key(boolean isInput) {
        this.isInput = isInput;
    }
}
