import React from "react";
import styled from "styled-components";

function CookingArea({ pans, onDropOnPan, onDropOnPlate }) {
  const handleDragOver = (e) => e.preventDefault();

  // 후라이팬에 드롭
  const handleDropOnPan = (index, e) => {
    e.preventDefault();
    const ingredient = e.dataTransfer.getData("text");
    onDropOnPan(index, ingredient);
  };

  return (
    <CookingAreaContainer>
      <FryerRow>
        <Fryer>감자튀김기</Fryer>
        <Fryer>감자튀김기</Fryer>
      </FryerRow>
      <PanRow>
        {pans.map((pan, index) => (
          <Pan
            key={index}
            onDragOver={handleDragOver}
            onDrop={(e) => handleDropOnPan(index, e)}
            draggable={pan && pan.status === "done"}
            onDragStart={(e) =>
              pan?.status === "done" &&
              e.dataTransfer.setData("text", "구운 패티")
            }
            onDragEnd={(e) => {
              if (pan?.status === "done") {
                // 패티를 성공적으로 접시에 놓았을 때만 후라이팬 초기화
                onDropOnPlate("구운 패티", index);
              }
            }}
            isDone={pan?.status === "done"}
          >
            {pan
              ? pan.status === "done"
                ? "구운 패티"
                : "굽는 중"
              : "후라이팬"}
          </Pan>
        ))}
      </PanRow>
    </CookingAreaContainer>
  );
}

export default CookingArea;

const CookingAreaContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 30%;
`;

const FryerRow = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
`;

const Fryer = styled.div`
  width: 120px;
  height: 120px;
  background: #7d7d7d;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  margin: 5px;
`;

const PanRow = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Pan = styled.div`
  width: 120px;
  height: 120px;
  background: ${(props) => (props.isDone ? "#d4a017" : "#848383")};
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  margin: 5px;
  cursor: ${(props) => (props.isDone ? "grab" : "pointer")};

  &:active {
    cursor: grabbing;
  }
`;
