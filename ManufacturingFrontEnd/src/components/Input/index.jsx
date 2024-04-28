import React from "react";
import PropTypes from "prop-types";

const shapes = {
  round: "rounded-[25px]",
};
const variants = {
  fill: {
    gray_400_70_01: "bg-gray-400_70_01 text-black-900_01",
    white_A700: "bg-white-A700",
    gray_400_70: "bg-gray-400_70",
  },
};
const sizes = {
  sm: "h-[60px] px-[30px] text-4xl",
  md: "h-[68px] px-[26px]",
  xs: "h-[55px] px-[26px]",
};

const Input = React.forwardRef(
  (
    {
      className = "",
      name = "",
      placeholder = "",
      type = "text",
      children,
      label = "",
      prefix,
      suffix,
      onChange,
      shape,
      variant = "fill",
      size = "xs",
      color = "",
      ...restProps
    },
    ref,
  ) => {
    const handleChange = (e) => {
      if (onChange) onChange(e?.target?.value);
    };

    return (
      <>
        <div
          className={`${className} flex items-center justify-center  ${(shape && shapes[shape]) || ""} ${variants[variant]?.[color] || variants[variant] || ""} ${sizes[size] || ""}`}
        >
          {!!label && label}
          {!!prefix && prefix}
          <input ref={ref} type={type} name={name} onChange={handleChange} placeholder={placeholder} {...restProps} />
          {!!suffix && suffix}
        </div>
      </>
    );
  },
);

Input.propTypes = {
  className: PropTypes.string,
  name: PropTypes.string,
  placeholder: PropTypes.string,
  type: PropTypes.string,
  label: PropTypes.string,
  prefix: PropTypes.node,
  suffix: PropTypes.node,
  shape: PropTypes.oneOf(["round"]),
  size: PropTypes.oneOf(["sm", "md", "xs"]),
  variant: PropTypes.oneOf(["fill"]),
  color: PropTypes.oneOf(["gray_400_70_01", "white_A700", "gray_400_70"]),
};

export { Input };
