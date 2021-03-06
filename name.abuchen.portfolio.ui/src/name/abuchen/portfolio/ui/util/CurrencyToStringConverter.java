package name.abuchen.portfolio.ui.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import name.abuchen.portfolio.model.Values;

import org.eclipse.core.databinding.conversion.IConverter;

public class CurrencyToStringConverter implements IConverter
{
    private final double factor;
    private final NumberFormat format;

    public CurrencyToStringConverter(Values<?> type)
    {
        this.factor = type.divider();
        this.format = new DecimalFormat(type.pattern());
    }

    @Override
    public Object getFromType()
    {
        return long.class;
    }

    @Override
    public Object getToType()
    {
        return String.class;
    }

    @Override
    public Object convert(Object fromObject)
    {
        Number v = (Number) fromObject;
        return format.format(v.longValue() / factor);
    }
}
