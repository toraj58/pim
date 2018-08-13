package com.touraj.pim.viewResolver;

import com.touraj.pim.view.PdfView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Created by toraj on 08/11/2018.
 */
public class PdfViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        return new PdfView();
    }
}
