package org.xtimms.kabegami.db.source;

import org.xtimms.kabegami.db.Recents;

import java.util.List;

import io.reactivex.Flowable;

public class RecentsRepository implements IRecentsDataSource{

    private final IRecentsDataSource mLocalDataSource;
    private static RecentsRepository instance;

    public RecentsRepository(IRecentsDataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static RecentsRepository getInstance(IRecentsDataSource mLocalDataSource) {
        if (instance == null) {
            instance = new RecentsRepository(mLocalDataSource);
        }
        return instance;
    }

    @Override
    public Flowable<List<Recents>> getAllRecents() {
        return mLocalDataSource.getAllRecents();
    }

    @Override
    public void insertRecents(Recents... recents) {
        mLocalDataSource.insertRecents(recents);
    }

    @Override
    public void updateRecents(Recents... recents) {
        mLocalDataSource.updateRecents(recents);
    }

    @Override
    public void deleteRecents(Recents... recents) {
        mLocalDataSource.deleteRecents(recents);
    }

    @Override
    public void deleteAllRecents() {
        mLocalDataSource.deleteAllRecents();
    }
}
