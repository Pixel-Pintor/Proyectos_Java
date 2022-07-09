package converter;

public enum IbidEnum {

    ZERO(new Base(0)),
    ONE(new Base(1)),
    TWO(new Base(2)),
    THREE(new Base(3)),
    FOUR(new Base(4)),
    FIVE(new Base(5)),
    SIX(new Base(6)),
    SEVEN(new Base(7)),
    EIGHT(new Base(8)),
    NINE(new Base(9)),
    A(new Base("A",10)),
    B(new Base("B", 11)),
    C(new Base("C",12)),
    D(new Base("D", 13)),
    E(new Base("E", 14)),
    F(new Base("F",15)),
    BINARY(new NumBase(2)),
    DECIMAL(new NumBase(10)),
    OCTAL(new NumBase(8)),
    HEXADECIMAL(new NumBase(16));

    private Base baseObject;
    private NumBase numBaseObject;

    IbidEnum(Base baseObject) {
        this.baseObject = baseObject;
    }

    IbidEnum(NumBase numBaseObject) {
        this.numBaseObject = numBaseObject;
    }

    public Base getBaseInstace() { return baseObject; }

    public NumBase getNumBaseObject() { return numBaseObject; }
}
