package com.hanna.wx.common.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hanna.wx.common.utils.FileNameUtils;

/**
 * ftp client
 * 
 * @author melodymao
 * @version $Id: LogisticsFtpClient.java, v 0.1 2015
 */
@Service
public class FtpClient {

    @Value("${ftp.server}")
    private String      serverUrl;            //ftp服务器地址                                                   

    @Value("${ftp.port}")
    private int         port;                 //ftp端口

    @Value("${ftp.username}")
    private String      username;            //登录用户名

    @Value("${ftp.password}")
    private String      password;             //登录密码

    public final String protocol = "http://";

    /**
     * 链接ftp
     * 
     * @return
     * @throws IOException 
     * @throws SocketException 
     */
    private FTPClient connect() throws Exception {

        FTPClient client = new FTPClient();

        client.connect(serverUrl, port);
        client.login(username, password);
        int reply = client.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            client.disconnect();
            return null;
        }

        return client;
    }

    /**
     * 上传文件，同名覆盖
     * 
     * @param directory
     * @param fileName
     * @param is
     * @return
     */
    public String upload(String directory, String fileName, InputStream is) {
        FTPClient client = null;
        try {
            //连接ftp
            if ((client = connect()) == null) {
                return null;
            }
            //上传文件
            return upload(client, directory, fileName, is);
        } catch (Exception e) {
        }
        return null;
    }

    private String upload(FTPClient client, String directory, String fileName, InputStream is) {
        boolean result = false;
        try {
            //保存文件
            result = client.changeWorkingDirectory(directory);
            //ftp目前只存图片
            client.setFileType(FTP.BINARY_FILE_TYPE);
            result = client.storeFile(fileName, is);
        } catch (Exception e) {
        } finally {
            if (null != client) {
                try {
                    client.disconnect();
                } catch (IOException e) {
                }
            }
        }
        return result ? protocol + serverUrl + "/" + directory + "/" + fileName : null;
    }

    /**
     * 上传文件，不覆盖原有文件
     * 
     * @param directory
     * @param is
     * @param suffix
     * @return
     */
    public String uploadFileWithoutCover(String directory, String suffix, InputStream is) {
        FTPClient client = null;

        try {
            //连接ftp
            if (client == null && (client = connect()) == null) {
                return null;
            }
            //获取文件名
            String fileName = FileNameUtils.getFileNameWithSuffix(suffix);
            if (fileExsits(client, directory, fileName)) {
                return uploadFileWithoutCover(directory, suffix, is);
            }
            return upload(client, directory, fileName, is);
        } catch (Exception e) {
        } finally {
            if (null != client) {
                try {
                    client.disconnect();
                } catch (IOException e) {
                }
            }
        }
        return null;

    }

    /**
     * 下载文件
     * 
     * @param directory 
     * @param ftpFile 
     * @param dstFile 
     * @return
     */
    public File download(String directory, String ftpFile, String dstFile) {
        File dFile = null;
        FileOutputStream fos = null;
        FTPClient client = null;
        try {
            dFile = new File(dstFile);
            if ((client = connect()) != null) {
                client.changeWorkingDirectory(directory);
                fos = new FileOutputStream(dFile);
                client.retrieveFile(ftpFile, fos);
            }

        } catch (Exception e) {
        } finally {
            if (null != client) {
                try {
                    client.disconnect();
                } catch (IOException e) {
                }
            }
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
        return dFile;
    }

    /**
     * 判断是否存在同名的文件
     * 
     * @param directory
     * @param fileName
     * @return
     */
    private boolean fileExsits(FTPClient client, String directory, String fileName) {
        boolean result = false;
        InputStream is = null;
        try {
            client.changeWorkingDirectory(directory);
            is = client.retrieveFileStream(fileName);
            result = (null != is);
        } catch (Exception e) {
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        return result;
    }

    /**
     * 返回服务器地址
     * 
     * @return
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * 协议
     * 
     * @return
     */
    public String getProtocol() {
        return protocol;
    }
}
