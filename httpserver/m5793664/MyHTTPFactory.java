package it.unifi.rc.httpserver.m5793664;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

import it.unifi.rc.httpserver.HTTPFactory;
import it.unifi.rc.httpserver.HTTPHandler;
import it.unifi.rc.httpserver.HTTPInputStream;
import it.unifi.rc.httpserver.HTTPOutputStream;
import it.unifi.rc.httpserver.HTTPServer;
import it.unifi.rc.httpserver.m5793664.handlers.MyHTTPHandler1_0;
import it.unifi.rc.httpserver.m5793664.handlers.MyHTTPHandler1_1;
import it.unifi.rc.httpserver.m5793664.server.MyHTTPServer;
import it.unifi.rc.httpserver.m5793664.streams.MyHTTPInputStream;
import it.unifi.rc.httpserver.m5793664.streams.MyHTTPOutputStream;

/**
 * Class that implements the interface {@link HTTPFactory}.
 * 
 * @author Gabriele Bertini, 5793664
 */
public class MyHTTPFactory implements HTTPFactory {
	/**
	 * @return {@link MyHTTPInputStream} created by his constructor.
	 */
	@Override
	public HTTPInputStream getHTTPInputStream(InputStream is) {
		return new MyHTTPInputStream(is);
	}

	/**
	 * @return {@link MyHTTPOutputStream} created by his constructor.
	 */
	@Override
	public HTTPOutputStream getHTTPOutputStream(OutputStream os) {
		return new MyHTTPOutputStream(os);
	}

	/**
	 * 
	 * @return {@link HTTPServer}
	 */
	@Override
	public HTTPServer getHTTPServer(int port, int backlog, InetAddress address, HTTPHandler... handlers) {
		return new MyHTTPServer(port, backlog, address, handlers);
	}

	/**
	 * @return {@link MyHTTPHandler1_0} with only {@code root}.
	 */
	@Override
	public HTTPHandler getFileSystemHandler1_0(File root) {
		return new MyHTTPHandler1_0(root);
	}

	/**
	 * @return {@link MyHTTPHandler1_0} with both {@code root} and {@code host}.
	 */
	@Override
	public HTTPHandler getFileSystemHandler1_0(String host, File root) {
		return new MyHTTPHandler1_0(root, host);
	}

	/**
	 * @return {@link MyHTTPHandler1_1} with only {@code root}.
	 */
	@Override
	public HTTPHandler getFileSystemHandler1_1(File root) {
		return  new MyHTTPHandler1_1(root);
	}

	/**
	 * @return {@link MyHTTPHandler1_1} with both {@code root} and {@code host}.
	 */
	@Override
	public HTTPHandler getFileSystemHandler1_1(String host, File root) {
		return new MyHTTPHandler1_1(root, host);
	}

	/**
	 * Method not implemented.
	 * 
	 * @return {@link HTTPHandler}
	 */
	@Override
	public HTTPHandler getProxyHandler() {
		return null;
	}
}