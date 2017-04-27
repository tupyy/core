package core;

import java.util.List;
import java.util.UUID;

/**
 * Interface for listen to the job events.
 * The job is sending events when the status has changed or a module has been finished running
 */
public interface JobListener {

    /**
     * Called when a job has been created
     * @param id
     */
    void jobCreated(UUID id);

    /**
     * Called when a job has been updated
     * @param id
     */
    void jobUpdated(UUID id);

    /**
     * Call when a jobs have been deleted
     * @param ids
     */
    void jobDeleted(UUID ids);

}