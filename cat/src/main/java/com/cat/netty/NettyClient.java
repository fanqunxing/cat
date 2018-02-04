package com.cat.netty;

import java.nio.channels.SocketChannel;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient 
{
	//http://blog.csdn.net/qq_28883885/article/details/70805183
	private int port;
    private String host;
    private SocketChannel socketChannel;
    
    public NettyClient(int port, String host) 
    		throws InterruptedException 
    {
        this.port = port;
        this.host = host;
        start();
    }
    
    private void start() throws InterruptedException 
    {
     EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
     try {
         Bootstrap bootstrap = new Bootstrap();
         bootstrap.channel(NioSocketChannel.class);
         bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
         bootstrap.group(eventLoopGroup);
         bootstrap.remoteAddress(host, port);
         bootstrap.handler(new ChannelInitializer<SocketChannel>() {
             @Override
             protected void initChannel(SocketChannel socketChannel) throws Exception {
                 socketChannel.pipeline().addLast(new NettyClientHandler());
                 socketChannel.pipeline().addLast(new HeartLinkHandler());
             }
         });
         ChannelFuture future = bootstrap.connect(host, port).sync();
         if (future.isSuccess()) {
             socketChannel = (SocketChannel) future.channel();
             System.out.println("------connect server success------");
         }
         future.channel().closeFuture().sync();
     } finally {
         eventLoopGroup.shutdownGracefully();    
     }
 }*
}
