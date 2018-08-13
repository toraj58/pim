package com.touraj.pim.viewResolver;

import com.touraj.pim.view.ExcelView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Created by toraj on 08/11/2018.
 */
public class ExcelViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        return new ExcelView();
    }
}
