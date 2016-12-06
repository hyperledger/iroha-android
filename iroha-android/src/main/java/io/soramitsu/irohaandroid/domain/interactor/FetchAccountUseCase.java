package io.soramitsu.irohaandroid.domain.interactor;

import io.soramitsu.irohaandroid.domain.repository.AccountRepository;
import rx.Observable;
import rx.Scheduler;

public class FetchAccountUseCase extends UseCase {

    private String uuid;
    private AccountRepository accountRepository;

    public FetchAccountUseCase(Scheduler onSubscribeThread, Scheduler onObserveThread,
                               String uuid, AccountRepository accountRepository) {
        super(onSubscribeThread, onObserveThread);
        this.uuid = uuid;
        this.accountRepository = accountRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return accountRepository.findByUuid(uuid);
    }
}