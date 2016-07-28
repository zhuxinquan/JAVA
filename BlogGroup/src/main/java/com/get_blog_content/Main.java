package com.get_blog_content;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-4-14.
 */
public class Main {
    public static void main(String[] args) {
        Collection<User> users = GetGroupUsers.getGroupusers();
        List blogContentInfos = new LinkedList<BlogContentInfo>();
        GetContentInfo getContentInfo = null;
        for (User u: users) {
            getContentInfo = new GetContentInfo(u.getBlogAddress(),  u.getBlogType(), u.getUpdateTime());
            blogContentInfos.addAll(getContentInfo.getContentInfo());
        }
        BlogContentCrud.storeBlogContentCollection(blogContentInfos);
    }
}
