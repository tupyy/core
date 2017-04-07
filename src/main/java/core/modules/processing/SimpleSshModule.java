package core.modules.processing;

import com.sshtools.sftp.SftpClient;
import com.sshtools.sftp.SftpStatusException;
import com.sshtools.ssh.ChannelOpenException;
import com.sshtools.ssh.SshClient;
import com.sshtools.ssh.SshException;
import com.sshtools.ssh2.Ssh2Client;
import core.modules.ModuleException;
import core.modules.SshModule;
import core.parameters.ParameterSet;
import core.tasks.ModuleTask;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Implements the abstract processing module. This module
 */
public abstract class SimpleSshModule implements SshModule{

    private org.slf4j.Logger logger = LoggerFactory.getLogger(SimpleSshModule.class);
    private  String moduleName = "SimpleSshModule";
    private List<String> methodNames = new ArrayList<>();

    public SimpleSshModule(String moduleName) {
        this.moduleName = moduleName;
    }
    @Override
    public String getName() {
        return moduleName;
    }

    @Override
    public ModuleTask runModule(UUID jobID, SshClient sshClient, ParameterSet parameterSet) throws ModuleException {
       return null;
    }

    @Override
    public List<String> getMethodsName() {
        return methodNames;
    }

    public void addMethod(String methodName) {
        methodNames.add(methodName);
    }

    /**
     * Create a new SftpClient
     * @param sshClient
     * @return
     * @throws SshException
     */
    public synchronized SftpClient getFtpClient(SshClient sshClient) throws SshException {

            Ssh2Client ssh2 = (Ssh2Client) sshClient;
            try {
                SftpClient sftpClient = new SftpClient(ssh2);
                return sftpClient;
            } catch (SftpStatusException e) {
                logger.error("Cannot create ftp client: {}", e.getMessage());
                throw new SshException("Cannot create ftp client", SshException.CHANNEL_FAILURE);
            } catch (ChannelOpenException e) {
                logger.error("Cannot open channel: {}", e.getMessage());
                throw new SshException("Cannot create ftp client", SshException.CHANNEL_FAILURE);
            }
        }
}