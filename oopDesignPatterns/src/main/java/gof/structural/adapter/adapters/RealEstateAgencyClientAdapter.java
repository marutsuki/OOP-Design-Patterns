package gof.structural.adapter.adapters;

import java.util.Properties;

public interface RealEstateAgencyClientAdapter {
    void rent(Properties properties);

    void cancel(Properties properties);
}
