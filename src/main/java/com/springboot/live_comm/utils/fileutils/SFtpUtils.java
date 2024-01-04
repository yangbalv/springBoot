//package com.springboot.live_comm.utils.fileutils;
//
//import org.apache.commons.lang3.StringUtils;
//import org.esbuilder.base.ServiceException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URLEncoder;
//import java.rmi.ServerException;
//import java.util.Objects;
//import java.util.Properties;
//
///**
// * Ftp协议传输文件-下载、上传
// *
// * @author lengwenpeng
// * @version 1.0.0
// * @since 1.0.0
// */
//public class SFtpUtils {
//    public static Logger logger = LoggerFactory.getLogger(SFtpUtils.class);
//
//    /**
//     * 文件上传
//     *
//     * @param host        主机
//     * @param port        端口
//     * @param username    用户名
//     * @param password    密码
//     * @param basePath    基本路径
//     * @param filePath    文件路径
//     * @param fileName    文件名
//     * @param inputStream 输入流
//     * @return 是否上传成功
//     * @throws IOException 流异常
//     */
//    public static boolean uploadFile(String host, int port, String username, String password, String basePath,
//                                     String filePath, String fileName, InputStream inputStream) throws IOException, ServiceException {
//        Session session = createSession(host, port, username, password);
//        ChannelSftp sftp = createChannelSftpBySession(session);
//        if (Objects.isNull(sftp)) {
//            throw new ServiceException("sftp连接失败");
//        }
//
//        try {
//            try {
//                sftp.cd(basePath + filePath);
//            } catch (SftpException e) {
//                //目录不存在，则创建文件夹
//                String[] dirs = (basePath + filePath).split("/");
//                String tempPath = "";
//                for (String dir : dirs) {
//                    if (null == dir || "".equals(dir)) {
//                        continue;
//                    }
//                    tempPath += "/" + dir;
//                    try {
//                        sftp.cd(tempPath);
//                    } catch (SftpException e1) {
//                        try {
//                            sftp.mkdir(tempPath);
//                            sftp.cd(tempPath);
//                        } catch (SftpException e2) {
//                            logger.error("创建文件夹失败", e2);
//                            throw new ServerException(e2.getMessage());
//                        }
//                    }
//                    try {
//                        sftp.cd(tempPath);
//                    } catch (SftpException e1) {
//                        logger.error("SFTP服务器异常", e1);
//                        throw new ServerException(e1.getMessage());
//                    }
//                }
//            }
//            //上传文件
//            sftp.put(inputStream, fileName);
//            logger.info("SftpUtils上传成功：{}{}", basePath, filePath);
//            return true;
//        } catch (Exception e) {
//            logger.error("上传文件失败：{}{}", basePath, filePath, e);
//        } finally {
//            try {
//                session = sftp.getSession();
//                if (sftp.isConnected()) {
//                    sftp.disconnect();
//                }
//            } catch (JSchException e) {
//                logger.error("获取session失败", e);
//            } finally {
//                if (session != null) {
//                    session.disconnect();
//                }
//            }
//        }
//        return false;
//    }
//
//    public static ChannelSftp createChannelSftpBySession(Session session) {
//        try {
//            Channel channel = session.openChannel("sftp");
//            channel.connect();
//            return (ChannelSftp) channel;
//        } catch (Exception ignored) {
//            ignored.printStackTrace();
//        }
//        return null;
//    }
//
//    private static Session createSession(String host, int port, String username, String password) {
//        try {
//            JSch jSch = new JSch();
//            Session session = jSch.getSession(username, host, port);
//            session.setTimeout(1000 * 180);
//
//            if (!StringUtils.isEmpty(password)) {
//                session.setPassword(password);
//            }
//            Properties config = new Properties();
//            config.put("StrictHostKeyChecking", "no");
//
//            session.setConfig(config);
//            session.connect();
//            return session;
//        } catch (Exception ignored) {
//        }
//        return null;
//    }
//
//    public static ChannelSftp getConnect(String ftpHost, String port, String ftpUserName, String ftpPassword) {
//        //默认的端口22 此处我是定义到常量类中；
//        int ftpPort = 22;
//        //判断端口号是否为空，如果不为空，则赋值
//        if (port != null && !port.equals("")) {
//            ftpPort = Integer.parseInt(port);
//        }
//        JSch jsch = new JSch(); // 创建JSch对象
//        // 按照用户名,主机ip,端口获取一个Session对象
//        try {
//            Session session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
//            if (ftpPassword != null) {
//                session.setPassword(ftpPassword); // 设置密码
//            }
//            String ftpTO = "20000";
//            if (!(ftpTO == null || "".equals(ftpTO))) {
//                int ftpTimeout = Integer.parseInt(ftpTO);
//                session.setTimeout(ftpTimeout); // 设置timeout时候
//            }
//            //并且一旦计算机的密匙发生了变化，就拒绝连接。
//            session.setConfig("StrictHostKeyChecking", "no");
//            //默认值是 “yes” 此处是由于我们SFTP服务器的DNS解析有问题，则把UseDNS设置为“no”
//            //session.setConfig("UseDNS", "no");
//            session.connect(); // 经由过程Session建树链接
//            ChannelSftp channel = (ChannelSftp) session.openChannel("sftp"); // 打开SFTP通道
//            channel.connect(); // 建树SFTP通道的连接
//            return channel;
//        } catch (JSchException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 下载远程文件
//     *
//     * @param dir  文件目录
//     * @param name 文件名
//     * @return 文件字节数组
//     */
//    public static void download(String host, int port, String username, String password, String dir,
//                                String name, HttpServletResponse response) throws ServiceException {
//        ChannelSftp sftp = null;
//        Session session = null;
//        try {
//            JSch jSch = new JSch();
//            session = jSch.getSession(username, host, port);
//            session.setTimeout(1000 * 180);
//
//            if (!StringUtils.isBlank(password)) {
//                session.setPassword(password);
//            }
//            Properties config = new Properties();
//            config.put("StrictHostKeyChecking", "no");
//
//            session.setConfig(config);
//            session.connect();
//
//            Channel channel = session.openChannel("sftp");
//            channel.connect();
//
//            sftp = (ChannelSftp) channel;
//
//        } catch (JSchException e) {
//            logger.error("连接SFTP服务器失败", e);
//        }
//        InputStream in;
//        try {
//            sftp.cd(dir);
//            in = sftp.get(name);
//        } catch (SftpException e) {
//            if (session != null) {
//                session.disconnect();
//            }
//            throw new ServiceException("文件下载失败", e);
//        }
//
//        FileInputStream fis = null;
//        BufferedInputStream bis = null;
//        try {
//            response.setContentType("application/force-download");// 设置强制下载不打开
//            response.setContentType("multipart/form-data;charset=UTF-8");//也可以明确的设置一下UTF-8，测试中不设置也可以。
//            response.setHeader("Content-Disposition", "attachment; fileName=" + name + ";filename*=utf-8''" + URLEncoder.encode(name, "UTF-8"));
//            byte[] buffer = new byte[1024];
//            bis = new BufferedInputStream(in);
//            OutputStream os = response.getOutputStream();
//            int i = bis.read(buffer);
//            while (i != -1) {
//                os.write(buffer, 0, i);
//                i = bis.read(buffer);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage(), e);
//        } finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    logger.error(e.getMessage(), e);
//                }
//            }
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    logger.error(e.getMessage(), e);
//                }
//            }
//            if (sftp != null) {
//                try {
//                    session = sftp.getSession();
//                    if (sftp.isConnected()) {
//                        sftp.disconnect();
//                    }
//                } catch (JSchException e) {
////                    log.error("获取session失败", e);
//                } finally {
//                    if (session != null) {
//                        session.disconnect();
//                    }
//                }
//            }
//
//
//        }
//    }
//    public static InputStream Videos(String host, int port, String username, String password, String dir,
//                                     String name, HttpServletResponse response) throws ServiceException {
//        ChannelSftp sftp = null;
//        Session session = null;
//        try {
//            JSch jSch = new JSch();
//            session = jSch.getSession(username, host, port);
//            session.setTimeout(1000 * 180);
//
//            if (!StringUtils.isBlank(password)) {
//                session.setPassword(password);
//            }
//            Properties config = new Properties();
//            config.put("StrictHostKeyChecking", "no");
//
//            session.setConfig(config);
//            session.connect();
//
//            Channel channel = session.openChannel("sftp");
//            channel.connect();
//
//            sftp = (ChannelSftp) channel;
//
//        } catch (JSchException e) {
//            logger.error("连接SFTP服务器失败", e);
//        }
//        InputStream in;
//
//        try {
//            sftp.cd(dir);
//            in = sftp.get(name);
//        } catch (SftpException e) {
//            if (session != null) {
//                session.disconnect();
//            }
//            throw new ServiceException("文件下载失败", e);
//        }
//        BufferedInputStream bis = null;
//        InputStream fis =null;
//        try {
//            response.setContentType("application/force-download");// 设置强制下载不打开
//            response.setContentType("multipart/form-data;charset=UTF-8");//也可以明确的设置一下UTF-8，测试中不设置也可以。
//            response.setHeader("Content-Disposition", "attachment; fileName=" + name + ";filename*=utf-8''" + URLEncoder.encode(name, "UTF-8"));
//            byte[] buffer = new byte[1024];
//            bis = new BufferedInputStream(in);
//            OutputStream os = response.getOutputStream();
//            int i = bis.read(buffer);
//            while (i != -1) {
//                os.write(buffer, 0, i);
//                i = bis.read(buffer);
//            }
//            fis =  in;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage(), e);
//        } finally {
//            if (bis != null) {
//                try {
//                    bis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    logger.error(e.getMessage(), e);
//                }
//            }
//
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    logger.error(e.getMessage(), e);
//                }
//            }
//            if (sftp != null) {
//                try {
//                    session = sftp.getSession();
//                    if (sftp.isConnected()) {
//                        sftp.disconnect();
//                    }
//                } catch (JSchException e) {
////                    log.error("获取session失败", e);
//                } finally {
//                    if (session != null) {
//                        session.disconnect();
//                    }
//                }
//            }
//
//        }
//        return fis;
//    }
//
//
//    /**
//     * 判断远程SFTP服务器上是否存在某个文件(用户名密码)
//     * （暂时没有被使用）
//     * @param directory 目录
//     * @param fileName  文件名
//     * @return 是否存在
//     */
//    public static boolean isExists(String directory, String fileName, String ftphost, int port, String ftpUserName, String ftpPassword) {
//        boolean isHave = false;
//        Session session = null;
//        try {
//             session = createSession(ftphost, port, ftpUserName, ftpPassword);
//            ChannelSftp sftp = createChannelSftpBySession(session);
//            if (Objects.isNull(sftp)) {
//                throw new ServerException("Sftp连接失败");
//            }
//            sftp.cd(directory);
//            SftpATTRS attrs = sftp.stat(fileName);
//            if (attrs != null) {
//                isHave = true;
//            }
//        } catch (Exception e) {
//        } finally {
//            if (session != null) {
//                session.disconnect();
//            }
//        }
//        return isHave;
//    }
//    //-------------------以下为密钥实现------------------------------------------//
//
//    /**
//     * 判断远程SFTP服务器上是否存在某个文件(密钥实现)
//     *
//     * @param directory 目录
//     * @param fileName  文件名
//     * @return 是否存在
//     */
//    public static boolean isExistsWithOutPass(String directory, String fileName, String ftphost, int port, String ftpUserName, String priKeyBasePath) throws ServerException {
//        boolean isHave = false;
//        Session session = null;
//        try {
//            session = createSessionWithOutPass(ftphost, port, ftpUserName, priKeyBasePath);
//            ChannelSftp sftp = createChannelSftpBySession(session);
//            if (Objects.isNull(sftp)) {
//                throw new ServerException("Sftp连接失败");
//            }
//            sftp.cd(directory);
//            logger.info("判断文件是否存在：{}",fileName);
//            SftpATTRS attrs = sftp.stat(fileName);
//            if (attrs != null) {
//                isHave = true;
//            }
//        } catch (SftpException e) {
//            throw new ServerException(e.getMessage());
//        } finally {
//            if (session != null) {
//                session.disconnect();
//            }
//        }
//        return isHave;
//    }
//
//    /**
//     * 创建SFTP连接
//     *
//     * @param host
//     * @param port
//     * @param username
//     * @param priKeyBasePath 私钥文件存储路径
//     * @return
//     */
//    public static Session createSessionWithOutPass(String host, int port, String username, String priKeyBasePath) {
//        try {
//            JSch jSch = new JSch();
//            Session session = jSch.getSession(username, host, port);
//            session.setTimeout(1000 * 180);
//            //添加私钥
//            jSch.addIdentity(priKeyBasePath);
//            Properties config = new Properties();
//            config.put("StrictHostKeyChecking", "no");
//
//            session.setConfig(config);
//            session.connect();
//            return session;
//        } catch (Exception ignored) {
//            ignored.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * 下载远程文件(密钥获取 文件流)
//     *
//     * @param fileDir  文件目录
//     * @param fileName 文件名
//     * @return 文件字节数组
//     */
//    public static InputStream downloadStream(String ftphost, int port, String ftpUserName,
//                                             String priKeyBasePath, String fileDir, String fileName) throws ServiceException {
//        Session session = createSessionWithOutPass(ftphost, port, ftpUserName, priKeyBasePath);
//        ChannelSftp sftp = createChannelSftpBySession(session);
//        if(Objects.isNull(sftp)){
//            throw new ServiceException("获取远端文件-Sftp连接失败");
//        }
//        InputStream in;
//        try {
//            sftp.cd(fileDir);
//            in = sftp.get(fileName);
//        } catch (SftpException e) {
//            e.printStackTrace();
//            throw new ServiceException("获取远端文件失败，文件下载失败", e.getMessage());
//        } finally {
//            if (session != null) {
//                session.disconnect();
//            }
//        }
//        return in;
//    }
//
//    /**
//     * 下载远程文件(密钥获取 文件流)
//     * 响应字节流
//     * @param fileDir  文件目录
//     * @param fileName 文件名
//     * @return 文件字节数组
//     */
//    public static ByteArrayOutputStream downloadStreamNotification(String ftphost, int port, String ftpUserName,
//                                             String priKeyBasePath, String fileDir, String fileName) throws ServiceException {
//        Session session = createSessionWithOutPass(ftphost, port, ftpUserName, priKeyBasePath);
//        ChannelSftp sftp = createChannelSftpBySession(session);
//        if(Objects.isNull(sftp)){
//            throw new ServiceException("获取远端文件-Sftp连接失败");
//        }
//        InputStream inputStream;
//        ByteArrayOutputStream baos;
//        try {
//            sftp.cd(fileDir);
//            inputStream = sftp.get(fileName);
//            baos = cloneInputStream(inputStream);
//        } catch (SftpException e) {
//            e.printStackTrace();
//            throw new ServiceException("获取远端文件失败，文件下载失败", e.getMessage());
//        } finally {
//            if (session != null) {
//                session.disconnect();
//            }
//        }
//        return baos;
//    }
//
//    //copy 流
//    private static ByteArrayOutputStream cloneInputStream(InputStream input) {
//        try {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = input.read(buffer)) > -1) {
//                baos.write(buffer, 0, len);
//            }
//            baos.flush();
//            return baos;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//}
