package org.sqlproc.meta.resolver;

public interface PojoResolverFactory {

    PojoResolver getPojoResolver();

    void setPojoResolver(PojoResolver pojoResolver);

}
