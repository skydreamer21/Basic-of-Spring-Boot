package skydreamer.SpringBasicMember.Service;

import skydreamer.SpringBasicMember.domain.Member;
import skydreamer.SpringBasicMember.repository.MemberRepository;
import skydreamer.SpringBasicMember.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private MemberRepository repository = new MemoryMemberRepository();

    public Long join(Member member) {
        // 중복 이름이 불가능 하다고 할 때
        checkDuplicatMember(member);
        repository.save(member);
        return member.getId();
    }

    private void checkDuplicatMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return repository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return repository.findById(id);
    }
}
