import React from "react";
import styled from "styled-components";
import ImageBlock from "../molecules/ImageBlock";
import DateBlock from "../molecules/DateBlock";
import BookButtonBlock from "../molecules/BookButtonBlock";
import NoteButtonBlock from "../molecules/NoteButtonBlock";

const Container = styled.View`
	width: 100%;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: flex-end;
	margin-bottom: 30px;
`;

const InfoWrapper = styled.View`
	display: flex;
	flex-direction: row;
	align-items: center;
`;

const UpperDetail = ({ contentInfo, truepress, falsepress, isBook }) => {
	const { bookCover, publicationDate, modifiedDate, isStored } = contentInfo;
	return (
		<Container>
			<InfoWrapper>
				<ImageBlock img={bookCover} />
				<DateBlock
					PublicationDate={publicationDate}
					ModifiedDate={modifiedDate}
				/>
			</InfoWrapper>
			{isBook ? (
				<BookButtonBlock
					isStored={isStored}
					truepress={truepress}
					falsepress={falsepress}
				/>
			) : (
				<NoteButtonBlock
					isStored={isStored}
					truepress={truepress}
					falsepress={falsepress}
				/>
			)}
		</Container>
	);
};

export default UpperDetail;
