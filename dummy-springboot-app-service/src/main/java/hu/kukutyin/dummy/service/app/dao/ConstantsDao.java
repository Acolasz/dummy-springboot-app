package hu.kukutyin.dummy.service.app.dao;

import hu.kukutyin.dummy.service.app.dao.exception.ConstantsDaoException;

public interface ConstantsDao {
    String completeFbUrl() throws ConstantsDaoException;

    String getVerifyToken() throws ConstantsDaoException;
}
