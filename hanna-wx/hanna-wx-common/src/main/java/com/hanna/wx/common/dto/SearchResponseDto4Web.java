package com.hanna.wx.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 为了适配web前端的搜索控件而新建的类
 * @author melodymao
 *
 */
public class SearchResponseDto4Web<T> {

    private List<Content> suggestions;

    public SearchResponseDto4Web() {
        suggestions = new ArrayList<Content>();
    }

    public class Content {
        private String value;
        private T      data;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public List<Content> getSuggestions() {
        return suggestions;
    }

    public void putValueToSuggestions(Content suggestion) {
        suggestions.add(suggestion);
    }

}
