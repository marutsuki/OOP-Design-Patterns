package gof.behavioural.mediator;

public abstract class Participant<S, R, M extends Mediator<S, R, M, P>, P extends Participant<S, R, M, P>> {
    protected M mediator;
    public Participant(M mediator) {
        this.mediator = mediator;
    }
    public abstract void receive(R context);
    public abstract void send(S context);
}
