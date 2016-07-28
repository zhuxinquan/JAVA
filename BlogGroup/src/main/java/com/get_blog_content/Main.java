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
        Collection<Tag> tags = Tag.getAllTags();
        List blogContentInfos = new LinkedList<BlogContentInfo>();
        GetContentInfo getContentInfo = null;
        for (User u: users) {
            for(Tag t : tags){
                if(t.getBlogType().equals(u.getBlogType())){
                    getContentInfo = new GetContentInfo(u, t);
                    blogContentInfos.addAll(getContentInfo.getContentInfo());
                    break;
                }
            }
        }
        BlogContentCrud.storeBlogContentCollection(blogContentInfos);
    }
}
