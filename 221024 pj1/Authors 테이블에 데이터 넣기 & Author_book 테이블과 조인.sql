----------------------------------------------------------
--Authors 테이블에 데이터 넣기 & Author_book 테이블과 조인
----------------------------------------------------------
insert into authors values(seq_author_no.nextval, '타이터스 윈터스', '구글에 2010년에 합류한 선임 소프트웨어 엔지니어. 지금은 C++ 표준 라이브러리를 설계하는 글로벌 소위원회 위원장이며, 구글에서는 매달 12,000명의 엔지니어가 수정하는 2억 5천만 라인의 코드로 이루어진 C++ 코드베이스의 라이브러리 리더를 맡고 있습니다. 지난 7년 동안은 최신 자동화 및 도구를 사용하여 구글 C++ 코드베이스의 기본 구성요소들을 재구성, 유지보수, 개선하는 팀을 이끌었습니다. 그 과정에서 역사상 가장 큰 리팩터링 10위 안에 들만한 여러 프로젝트를 경험했습니다.');
insert into authors values(seq_author_no.nextval, '톰 맨쉬렉', '구글에서 2005년부터 소프트웨어 엔지니어링 부분 테크티컬 라이터로 근무하며 인프라와 언어에 관한 주요 프로그래밍 가이드를 작성하고 관리하는 업무를 담당했습니다. 2011년부터는 구글 C++ 라이브러리팀에 합류하여 구글 C++ 문서자료를 만들고, (타이터스와 함께) 구글 C++ 교육 클래스를 론칭했으며, 구글의 오픈 소스 C++ 코드인 Abseil의 문서화도 진행했습니다. 매사추세츠 공과대학교에서 정치학 학사와 역사 학사를 받았습니다. 구글에 합류하기 전에는 피어슨, 프랜티스 홀, 다양한 스타트업에서 편집장으로 근무했었습니다.');
insert into authors values(seq_author_no.nextval, '하이럼 라이트', '구글에 2012년에 합류한 소프트웨어 엔지니어. 구글 C++ 코드베이스의 대규모 유지보수 업무를 담당했습니다. 구글 역사에서 구글 코드베이스를 가장 많이 수정한 사람으로 손꼽히며 구글의 자동 변경 도구 그룹을 이끌고 있습니다. 텍사스 대학교에서 소프트웨어 엔지니어링 박사 학위를 받았고 카네기 멜론 대학교에서 비정기 방문 교수로 재직 중입니다. 콘퍼런스 연사로 활발히 활동하며 소프트웨어 유지보수 및 진화 관련 학술 문헌을 꾸준히 기고합니다.');
select book_no from books where book_name = '구글 엔지니어는 이렇게 일한다';
select author_no from authors where author_name = '타이터스 윈터스';
select author_no from authors where author_name = '톰 맨쉬렉';
select author_no from authors where author_name = '하이럼 라이트';
insert into author_book values(17, 28);
insert into author_book values(18, 28);
insert into author_book values(19, 28);

insert into authors values(seq_author_no.nextval, '박해선', '기계공학을 전공했으나 졸업 후엔 줄곧 코드를 읽고 쓰는 일을 했다. 지금은 ML GDE(Machine Learning Google Developer Expert)로 활동하고 있고, 머신러닝과 딥러닝에 관한 책을 집필하고 번역하면서 소프트웨어와 과학의 경계를 흥미롭게 탐험하고 있다.
『핸즈온 머신러닝 2판』(한빛미디어, 2020)을 포함해서 여러 권의 머신러닝, 딥러닝 책을 우리말로 옮겼고 『Do it! 딥러닝 입문』(이지스퍼블리싱, 2019)을 집필했다.
https://tensorflow.blog');
select book_no from books where book_name = '혼자 공부하는 머신러닝+딥러닝';
select author_no from authors where author_name = '박해선';
insert into author_book values(24, 48);

insert into authors values(seq_author_no.nextval, 'Behrouz', 'Behrouz는 디엔자 대학의 교수이며 컴퓨터 정보 시스템 과정 개발에 참여했다. 또한 여러 회사에 시스템 개발 컨설팅도 병행하고 있다. C와 C++ 저서 외에도 컴퓨터 네트워크(Top-Down Approach, TCP / IP Protocol Suite 및 Local Area Networks)를 비롯한 다양한 서적을 저술했다.');
select book_no from books where book_name = '암호학과 네트워크 보안';
select author_no from authors where author_name = 'Behrouz';
insert into author_book values(27, 29);

insert into authors values(seq_author_no.nextval, '말콤 맥도널드', '인터넷에서 웹 개발을 위한 가장 인기 있는 보안 훈련 자원 중 하나인 hacksplaining.com을 만들었다. 금융 회사와 스타트업을 위한 코드를 작성했고, 팀을 이끌었던 경험을 바탕으로 보안 취약점을 보호하는 방법을 간단하고 이해하기 쉬운 튜토리얼로 제작했다.');
select book_no from books where book_name = '웹 개발자를 위한 웹 보안';
select author_no from authors where author_name = '말콤 맥도널드';
insert into author_book values(29, 30);

insert into authors values(seq_author_no.nextval, '임호진', '저서로는 정보처리기술사를 위한 IT 산업 정보시스템, 정보처리기술사 수검전략(세리 기술사회에서 추천하는), 정보처리기술사 디지털 데이터 매니지먼트, 정보처리기술사 기출문제 해설집, 정보처리기술사 제86회 기출문제 해설집, 정보처리기술사 합격전략서, 정보처리기술사 핵심문제 해설집 1편, 정보처리기술사 핵심문제 해설집 2편, 정보시스템감리사 합격전략서, 정보시스템감리사 기출문제 해설집, Advanced Oracle Database 활용과 튜닝, 고성능 데이터베이스 구축 방법론, CEO의 관점으로 IT를 바라보자 등이 있다.');
insert into authors values(seq_author_no.nextval, '박종범', '한양여자대학교 스마트 IT과 교수, 공학박사다.');
insert into authors values(seq_author_no.nextval, '임준혁', '대표작으로 『2022 이기적 ADsP 데이터분석 준전문가』이/가 있다.');
select book_no from books where book_name = '이기적 SQL 개발자 이론서+기출문제';
select author_no from authors where author_name = '임호진';
select author_no from authors where author_name = '박종범';
select author_no from authors where author_name = '임준혁';
insert into author_book values(34, 31);
insert into author_book values(35, 31);
insert into author_book values(36, 31);

insert into authors values(seq_author_no.nextval,'박찬권', '방송통신대에서 컴퓨터과학을 전공했으며 게임 개발자 출신이다. DB 튜닝, 데이터 마트 설계, 업무 모델링 등 수많은 프로젝트를 성공적으로 이끈 데이터 스페셜리스트다. 실무뿐 아니라 여러 대학 특강과 기업 특강을 통해 실력파 데이터 전문가로 인정받고 있다. 네이버 카페 ‘데이터와 사람들’에서 ‘칼찬요정’이라는 이름으로 튜닝 강의와 진로 상담을 하여 팬들로부터 사랑받고 있다.');
select book_no from books where book_name = '오라클 튜닝 에센셜';
select author_no from authors where author_name = '박찬권';
insert into author_book values(39, 32);

insert into authors values(seq_author_no.nextval, '고경희', '저자는 2010년 《Do it! HTML5 + CSS3》 출간 이후 꾸준히 HTML5 강의를 해왔다. 자타공인 HTML 권위자인 저자는 웹 초창기부터 ASP와 JAVA 등 전문 도서를 번역하면서 웹 기술에 관심을 가지기 시작했다. 이후 HTML과 DHTML(Dynamic HTML), CSS, JavaScript 등 웹 관련 기술을 좀 더 쉽게 익힐 수 있는 도서 60여 종을 집필했다. 현재 마이크로소프트 공인 최고 기술자(Microsoft Most Valuable Professional)로 활동 하고 있다.');
select book_no from books where book_name = 'Do it! HTML+CSS+자바스크립트 웹 표준의 정석';
select author_no from authors where author_name = '고경희';
insert into author_book values(44, 33);

insert into authors values(seq_author_no.nextval, '장정우', '삼성SDS에서 인프라 엔지니어 및 백엔드 개발자로 근무했으며, 현재는 위대한상상에서 결제 시스템 개발 업무를 담당하고 있습니다. 그리고 유튜브 〈어라운드허브 스튜디오〉를 운영하면서 프로그래밍 정보를 공유하고 있습니다.');
select book_no from books where book_name = '스프링 부트 핵심 가이드';
select author_no from authors where author_name = '장정우';
insert into author_book values(47, 34);

insert into authors values(seq_author_no.nextval, '김나무', '이모티콘 작가. 경기예술고등학교 만화창작과, 교토조형예술대학교 정보디자인과를 거치며 그림과의 연을 이어갔다. 졸업 후 그래픽 디자이너로 일을 하다가 웹툰 작가가 되기 위해 과감히 퇴사를 결정했다. 웹툰 작가 준비 중 우연한 기회로 시작한 이모티콘 제작이 제2의 인생을 열어주었다.
친근한 그림체와 공감 가는 문구로 출시하는 이모티콘마다 한결같은 인기를 누리고 있다. 지난 6년간 경험하며 쌓은 이모티콘 제작 노하우를 가감 없이 공개하고자 집필에 나섰다. 또한 강의나 방송 등을 통해 활동 영역을 넓히고 있는 중이다.');
select book_no from books where book_name = '무조건 돈 버는 카카오 이모티콘 만들기';
select author_no from authors where author_name = '김나무';
insert into author_book values(59, 38);

insert into authors values(seq_author_no.nextval, '김민준', '개발은 언제나 즐겁고 재밌어야 한다는 생각을 갖고 있는 개발자이며, IT 기술을 가르치는 것을 굉장히 좋아하는 교육자이다. 또한, 사용자를 행복하게 만드는 서비스를 만드는 것이 가장 중요하다고 여긴다. 현재 리디(주)에서 애니메이션 스트리밍 서비스 라프텔(laftel.net)의 프런트엔드 개발을 하고 있다. 그리고 개발자들의 블로그 서비스인 벨로그(velog.io)를 운영 및 개발하고 있다.');
select book_no from books where book_name = '리액트 네이티브를 다루는 기술';
select author_no from authors where author_name = '김민준';
insert into author_book values(60, 36);

commit;