package gof.behavioural.mediator;

import java.util.List;

public abstract class Mediator<S, R, M extends Mediator<S, R, M, P>, P extends Participant<S, R, M, P>> {
    protected List<P> participants;
    public abstract void handle(S context);
}
