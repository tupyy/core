package stes.isami.core;

import stes.isami.core.job.Job;
import stes.isami.core.job.JobException;
import stes.isami.core.ssh.SshFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Core interface
 */

public interface Core {

    /**
     * Load plugin from folder {@code pluginPath}
     * @param pluginPath
     * @throws IOException of pluginPath not found
     */
    public void loadPlugins(String pluginPath) throws IOException;

    /**
     * Add a new job
     * @param job
     */
    public boolean addJob(Job job) throws JobException;

    /**
     * Delete the job. A job which is running cannot be deleted immediately.
     * <br>The job is marked for deletion and a QDel module is executed with the id of the job.
     * <br>Once the job have been deleted from the batch system, the job can be safely deleted from jobList.
     * @param id
     * @throws JobException
     */
    public boolean deleteJob(UUID id);

    /**
     * Stop job
     * @param id
     */
    public void stopJob(UUID id);

    /**
     * Get the job
     * @param id
     * @return Job
     */
    public Job getJob(UUID id);

    /**
     * Run job
     * @param id
     */
    public void executeJob(UUID id) throws IllegalStateException;

    /**
     * Execute all the jobs
     */
    public void executeAll();

    /**
     * Return the SshFactory
     * @return
     */

    public SshFactory getSshFactory();
    /**
     * Count the number of jobs
     * @return
     */
    public int count();

    /**
     * Get the list of ids of all jobs
     * @return ArrayList of IDs
     */
    public ArrayList<UUID> getJobIDList();
    /**
     * Add job listener
     * @param listener
     */
    public void addJobListener(JobListener listener);

    /**
     * Remove job listener
     * @param listener
     */
    public void removeJobListener(JobListener listener);

    /**
     * Close the executors
     */
    public void shutdown();

}