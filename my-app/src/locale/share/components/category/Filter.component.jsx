import React from "react";
import Accordion from "./Accordion.component";

const Filter = () => {
  return (
    <div className="max-w-md mx-auto mt-10">
      <div className="flex flex-wrap items-center justify-between mx-10">
        <p className="text-white">Filter</p>
        <p className="text-cyan-600">Reset</p>
      </div>
      <div className="form-control pt-2 justify-center text-center align-content-center">
        <input
          type="text"
          placeholder="keywords"
          className="rounded-full bg-customInputBg1 px-2 py-1"
        />
      </div>
      <div>
        <Accordion />
      </div>
    </div>
  );
};

export default Filter;
