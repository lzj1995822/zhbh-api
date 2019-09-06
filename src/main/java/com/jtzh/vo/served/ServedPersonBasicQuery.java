package com.jtzh.vo.served;

import com.jtzh.entity.ServedPersonBasic;
import com.jtzh.util.Page;

import java.util.List;

public class ServedPersonBasicQuery {

    private Page page;

    private List<ServedPersonBasic> vos;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<ServedPersonBasic> getVos() {
        return vos;
    }

    public void setVos(List<ServedPersonBasic> vos) {
        this.vos = vos;
    }
}
